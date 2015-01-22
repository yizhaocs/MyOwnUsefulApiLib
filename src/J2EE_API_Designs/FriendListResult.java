package J2EE_API_Designs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yizhao on 1/21/15.
 */
public class FriendListResult extends StatusResult {

    private List<FriendResult> friends = new ArrayList<FriendResult>();

    public FriendListResult() {
        super();
    }

    public FriendListResult(String status) {
        super(status);
    }

    public void setFriends(List<FriendResult> friends) {
        this.friends = friends;
    }

    public List<FriendResult> getFriends() {
        return friends;
    }

    public class FriendResult {

        private Long userId;
        private String userName;
        private Long character;
        private Long characterColor;
        private Long clothing;
        private String accessories;
        private Long background;
        private String avatarUrl;
        private Boolean isParent = false;
        private int relationship = 0;
        private Long osgKidId;
        private String osgUserKey;

        public FriendResult() {

        }

        public FriendResult(Long userId, String userName, Long character, Long characterColor, Long clothing,
                            String accessories, Long background, String avatarUrl, Long osgKidId, String osgUserKey) {
            this.setUserId(userId);
            this.setUserName(userName);
            this.setCharacter(character);
            this.setCharacterColor(characterColor);
            this.setClothing(clothing);
            this.setAccessories(accessories);
            this.setBackground(background);
            this.setAvatarUrl(avatarUrl);
            this.setOsgKidId(osgKidId);
            this.setOsgUserKey(osgUserKey);
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
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


        public Boolean getIsParent() {
            return isParent;
        }


        public void setIsParent(Boolean isParent) {
            this.isParent = isParent;
        }

        public void setRelationship(int relationship) {
            this.relationship = relationship;
        }

        public int getRelationship() {
            return relationship;
        }

        public void setOsgKidId(Long osgKidId) {
            this.osgKidId = osgKidId;
        }

        public Long getOsgKidId() {
            return osgKidId;
        }

        public void setOsgUserKey(String osgUserKey) {
            this.osgUserKey = osgUserKey;
        }

        public String getOsgUserKey() {
            return osgUserKey;
        }


    }

}