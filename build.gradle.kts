// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.jetbrains.kotlin.android).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
}