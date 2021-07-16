package code.controllers;

public class Defaults {
    public static final int MINIMUM_PASSWORD_LEN = 8;
    public static final int MAXIMUN_PASSWORD_LEN = 40;
    public static final String INVALID_CONFIRM_PASSWORD_MESSAGE = " [-] تکرار رمز عبور با رمز عبور یکسان نیست." ;
    public static final String REGISTER_SUCCESS_MESSAGE = "ثبت نام با موفقیت انجام شد.";
    protected static final int MINIMUM_USERS_LEN = 3;
    protected static final String INVALID_LEN_MESSAGE = "[-] the length %s field must greater than %d character";
    protected static final String INVALID_EMAIL_MESSAGE = "[-] الگوی درستی برای ایمیل وارد کنید.";
    protected static final String INVALID_IMAGE_URI = "res//drawable//crying-5168.png";
    protected static final String VALID_IMAGE_URI = "res//drawable//smile-5145.png";
    protected static final String INVALID_LEN_PASSWORD_MESSAGE = "[-] طول رمز عبور در محدوده [8و40) باشد. ";
    protected static final String INVALID_PASSWORD_PATTERN_MESSAGE = "[-] رمز عبور باید حداقل شامل یک حرف لاتین بزرگ و یک حرف لاتین کوچک و یک عدد و یک علامت باشد.";
    protected static final String WELCOME_IMAGE_URI = "res/drawable/welcome.jpg";
    protected static final String[] GROUNDS_URIS = {
            "res//drawable//ground01.png",
            "res//drawable//ground02.png",
            "res//drawable//ground03.png",
            "res//drawable//ground04.png",
            "res//drawable//ground17.png",
            "res//drawable//ground18.png",
    };
    protected static final String[] RIVERS_URIS = {
            "res//drawable//river1.png",
            "res//drawable//river2.png"
    };
    protected static final String[] BRIDGES_URIS = {
            "res//drawable//bridge1.png",
            "res//drawable//bridge2.png"
    };
    protected static final int RIVERS_LENGTH = RIVERS_URIS.length;
    protected static final int TILES_KIND_COUNT = GROUNDS_URIS.length;
    protected static final int BRIDGES_KIND_COUNT = BRIDGES_URIS.length;
    protected static final int TILE_WIDTH = 25;
    protected static final int TILE_HEIGHT = 25;
    protected static final double RIVER_PERCENT_PER_MAP_SIDE = .05;
    protected static final double BRIDGE_PERCENT = .08;
    protected static final double CASTLE_ROW_PERCENT = .04;
    protected static final String[] CASTLES_URIS = {
            "res//drawable//tower2.png",
            "res//drawable//tower1.png",
            "res//drawable//tower3.png"
    };
    protected static final int KING_CASTLE_WIDTH = 60;
    protected static final int KING_CASTLE_HEIGHT = 80;

}
