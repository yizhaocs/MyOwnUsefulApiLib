package main.java.StatusCodes;

/**
 * Created by yizhao on 1/21/15.
 */
public class LoginResult extends StatusResult {
    private Long userId;

    private String friendCode;

    private String sessionKey;

    private String firstName;

    private String lastName;

    private String userName;

    private Long character;

    private Long characterColor;

    private Long clothing;

    private String accessories;

    private Long background;

    private String avatarUrl;

    private Long osgKidId;

    public LoginResult() {

    }

    public LoginResult(String statusCode) {
        super(statusCode);
    }

    public LoginResult(Long userId, String friendCode, String sessionKey, String firstName, String lastName,
                       Long character, Long characterColor, Long clothing, String accessories, Long background, String avatarUrl,
                       String userName, Long osgKidId) {
        super();
        this.userId = userId;
        this.friendCode = friendCode;
        this.sessionKey = sessionKey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.character = character;
        this.characterColor = characterColor;
        this.clothing = clothing;
        this.accessories = accessories;
        this.background = background;
        this.avatarUrl = avatarUrl;
        this.userName = userName;
        this.osgKidId = osgKidId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFriendCode() {
        return friendCode;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCharacter(Long character) {
        this.character = character;
    }

    public Long getCharacter() {
        return character;
    }

    public void setCharacterColor(Long characterColor) {
        this.characterColor = characterColor;
    }

    public Long getCharacterColor() {
        return characterColor;
    }

    public void setClothing(Long clothing) {
        this.clothing = clothing;
    }

    public Long getClothing() {
        return clothing;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setBackground(Long background) {
        this.background = background;
    }

    public Long getBackground() {
        return background;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getOsgKidId() {
        return osgKidId;
    }

    public void setOsgKidId(Long osgKidId) {
        this.osgKidId = osgKidId;
    }

}