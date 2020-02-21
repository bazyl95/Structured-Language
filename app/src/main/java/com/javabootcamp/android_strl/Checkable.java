package com.javabootcamp.android_strl;

    /*
    * Interface made to allow from TopicAdapter to call to method in MainActivity to start WordActivity.
    * Management of Activities stays within activities and not adapters ... principle
     * */
public interface Checkable {
    public void checkCompleted();
}
