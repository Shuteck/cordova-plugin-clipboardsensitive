# cordova-plugin-clipboardsensitive

This plugin fixes de Cordova Android vulneravility "Starting with Android 13, the system will display any text that is copied in a popover UI on the user's screen. If the user has copied sensitive content (such as a password), this can lead to sensitive data exposure" by adding this JAVA code 

SECURE CODE
// When the App targets API level 33 or higher
clipData.apply {
    description.extras = PersistableBundle().apply {
        putBoolean(ClipDescription.EXTRA_IS_SENSITIVE, true)
    }
}

// When the App targets a lower API level
clipData.apply {
    description.extras = PersistableBundle().apply {
        putBoolean("android.content.extra.IS_SENSITIVE", true)
    }
}
