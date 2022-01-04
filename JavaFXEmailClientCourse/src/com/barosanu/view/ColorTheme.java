package com.barosanu.view;

public enum ColorTheme {
    LIGHT,
    DEFAULT,
    DARK;

    // Tworzymy połączenie pomiędzy plikiem css i ENUM, z którym dany plik koresponduje
    public static String getCssPath(ColorTheme colorTheme) {
        switch (colorTheme) {
            case LIGHT:
                return "css/themeLight.css";
            case DEFAULT:
                return "css/themeDefault.css";
            case DARK:
                return "css/themeDark.css";
            default:
                return null;
        }
    }
}
