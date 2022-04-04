

public class Restaurant extends User{
    String restaurantName;
    int permissions;

    public Restaurant(String newFirstName, String newLastName, String newUsername, String newPassword, int newUserID, String newRestaurantName, int newPermissions) {
        super(newFirstName,newLastName,newUsername,newPassword,newUserID);
        this.restaurantName = newRestaurantName;
        this.permissions = newPermissions;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public boolean setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return true;
    }

    public int getPermissions() {
        return permissions;
    }

    public boolean setPermissions(int permissions) {
        this.permissions = permissions;
        return true;
    }
}
