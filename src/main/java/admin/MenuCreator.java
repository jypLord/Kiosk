package admin;

import java.io.IOException;

public interface MenuCreator {

  //TODO: add admin.MenuItem to ArrayList
  void addMenuItem(MenuItem menuItem);

  //TODO: administrate JSON file by user.Menu Type
  void toJson() throws IOException;
}
