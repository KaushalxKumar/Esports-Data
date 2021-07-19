package Model.Data;

import java.util.LinkedHashMap;
import java.util.List;

public class League {
    private int id;
    private String image_url;
    private String modified_at;
    private String name;
    private List<Object> series;
    private String slug;
    private String url;
    private Object videogame;

    /**
     * Default league constructor.
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     */
    public League() {
        super();
    }

    /**
     * Preferred league constructor.
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @param id the league id.
     * @param imageURL the league image url.
     * @param modified the time league was modified at.
     * @param name the league name.
     * @param series the series for the league.
     * @param slug the league slug.
     * @param leagueURL the league url.
     * @param game the league game.
     */
    public League (int id, String imageURL, String modified, String name, List<Object> series, String slug, String leagueURL, Object game) {
        this.id = id;
        this.image_url = imageURL;
        this.modified_at= modified;
        this.name = name;
        this.series = series;
        this.slug = slug;
        this.url = leagueURL;
        this.videogame = game;
    }

    /**
     * Simple accessor for league id<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The league ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Simple accessor for league image url<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The league image url.
     */
    public String getImage_url() {
        return image_url;
    }

    /**
     * Simple accessor for league modified time.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The league modified time.
     */
    public String getModified_at() {
        return modified_at;
    }

    /**
     * Simple accessor for league name.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The league name.
     */
    public String getName() {
        return name;
    }

    /**
     * Simple accessor for league series.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series for the league.
     */
    public List<Object> getSeries() {
        return series;
    }

    /**
     * Simple accessor for league slug.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The league slug.
     */
    public String getSlug() {
        return slug;
    }

    /**
     * Simple accessor for league url.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The league url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Simple accessor for league video game.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The league video game.
     */
    public Object getVideogame() {
        return videogame;
    }

    /**
     * Simple accessor for league representation.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The league representation.
     */
    @Override
    public String toString() {
        LinkedHashMap game = (LinkedHashMap) this.videogame;
        String gameName = (String) game.get("name");
        return gameName + ": " + name + " League";
    }

}
