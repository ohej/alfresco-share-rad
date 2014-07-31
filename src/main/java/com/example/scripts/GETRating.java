package com.example.scripts;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.extensions.webscripts.Cache;
import org.springframework.extensions.webscripts.DeclarativeWebScript;
import org.springframework.extensions.webscripts.Status;
import org.springframework.extensions.webscripts.WebScriptRequest;

import com.example.beans.RatingBean;

/**
 * This is the controller for the rating.post web script.
 *
 * @author jpotts
 *
 */
public class GetRating extends DeclarativeWebScript {

    Logger logger = Logger.getLogger(GetRating.class);

    private RatingBean ratingBean;


    @Override
    protected Map<String, Object> executeImpl(WebScriptRequest req,
                                              Status status, Cache cache) {
        String id = "Test ID";
        String rating = "123";
        String user = "User1";

        if (id == null || rating == null || rating.equals("0") || user == null) {
            logger.debug("ID, rating, or user not set");
            status.setCode(400, "Required data has not been provided");
            status.setRedirect(true);
        } else {
                ratingBean.create(Integer.parseInt(rating), user);
                logger.debug("Back from ratingBean.create()");
        }

        logger.debug("Setting model");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("node", id);
        model.put("rating", rating);
        model.put("user", user);

        return model;
    }

    public RatingBean getRatingBean() {
        return ratingBean;
    }

    public void setRatingBean(RatingBean ratingBean) {
        this.ratingBean = ratingBean;
    }

}