// Top-level build file where you can add configuration options common to all sub-projects/modules.

apply(from = "./code_quality/detekt.gradle")
apply(from = "./code_style/ktlint.gradle")
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.ksp) apply false
}
