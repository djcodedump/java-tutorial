package com.deb.ex.annotation_examples;

@ClassPreamble(
        author = "Deba",
        date = "17/07/2011",
        currentVersion = 6,
        lastModified = "17/07/2021",
        lastModifiedBy = "Deba",
        reviewers = {"me", "myself", "self"}
)
@SuppressWarnings("unchecked")
public class DemoClass {

    @ClassPreamble(
            author = "Dip",
            reviewers = "Deba",
            date = "19-07-2021"
    )
    public String getString(){
        return "method in Class";
    }
}
