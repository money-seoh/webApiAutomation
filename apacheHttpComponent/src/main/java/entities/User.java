package entities;

public class User {

    public static final String LOGIN = "login";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String URL = "url";
    public static final String PUBLIC_REPOS = "public_repos";
    public static final String REPOS_URL = "repos_url";

    private String login;
    private String id;
    private String name;
    private String url;
    private String public_repos;
    private String repos_url;

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public String getRepos_url() {
        return repos_url;
    }
}
