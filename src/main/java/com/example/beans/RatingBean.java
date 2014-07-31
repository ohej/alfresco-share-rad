package com.example.beans;

import org.apache.log4j.Logger;

public class RatingBean {

    private Logger logger = Logger.getLogger(RatingBean.class);

    public void create(final int rating, final String user) {
        logger.debug(String.format("Inside RatingBean.create(%s,%s)", rating, user));
    }
}