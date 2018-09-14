package com.zacha.galleryapp;

import java.util.List;

/** Feed of Google+ activities. */
public static class ActivityFeed {

    /** List of Google+ activities. */
    @Key("items")
    private List<Activity> activities;

    public List<Activity> getActivities() {
        return activities;
    }
}

/** Google+ activity. */
public static class Activity extends GenericJson {

    /** Activity URL. */
    @Key
    private String url;

    public String getUrl() {
        return url;
    }

    /** Activity object. */
    @Key("object")
    private ActivityObject activityObject;

    public ActivityObject getActivityObject() {
        return activityObject;
    }
}

/** Google+ activity object. */
public static class ActivityObject {

    /** HTML-formatted content. */
    @Key
    private String content;

    public String getContent() {
        return content;
    }

    /** People who +1'd this activity. */
    @Key
    private PlusOners plusoners;

    public PlusOners getPlusOners() {
        return plusoners;
    }
}

/** People who +1'd an activity. */
public static class PlusOners {

    /** Total number of people who +1'd this activity. */
    @Key
    private long totalItems;

    public long getTotalItems() {
        return totalItems;
    }
}