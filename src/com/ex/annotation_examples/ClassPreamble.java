package com.ex.annotation_examples;

import java.lang.annotation.*;

// meta-annotations apply to other annotations
//using @Documented make the information in the annotation definition appear in javadoc
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface ClassPreamble {
    String author();
    String date();
    int currentVersion() default 1;
    String lastModified() default "NA";
    String lastModifiedBy() default "NA";
    String[] reviewers();
}
