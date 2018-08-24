package reposidory;

import java.util.List;

public interface BlogOperations {

    List<String > findTagsByFragment(String fragment);
    List<String > findAllTags();

}
