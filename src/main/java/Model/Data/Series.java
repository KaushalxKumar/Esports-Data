package Model.Data;

import java.util.List;

public class Series {
    private String begin_at;
    private String description;
    private String end_at;
    private String full_name;
    private int id;
    private Object league;
    private int league_id;
    private String modified_at;
    private String name;
    private String season;
    private String slug;
    private String tier;
    private List<Object> tournaments;
    private Object videogame;
    private Object videogame_title;
    private int winner_id;
    private String winner_type;
    private int year;


    /**
     * Default series constructor.
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     */
    public Series() {
        super();
    }

    /**
     * Preferred series constructor.
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @param begin_at the series start time.
     * @param description the series description.
     * @param end_at the series end time.
     * @param full_name the series full name.
     * @param id the series id
     * @param league the league for the series.
     * @param league_id the league id for the series.
     * @param modified_at the series modified time.
     * @param name the series name.
     * @param season the series season.
     * @param slug the series slug.
     * @param tier the series tier.
     * @param tournaments the series tournaments.
     * @param videogame the series video game.
     * @param videogame_title the series video game title.
     * @param winner_id the series winner id.
     * @param winner_type the series winner type.
     * @param year the series year.
     */
    public Series(String begin_at, String description, String end_at, String full_name, int id, Object league, int league_id, String modified_at, String name, String season, String slug, String tier, List<Object> tournaments, Object videogame, Object videogame_title, int winner_id, String winner_type, int year) {
        this.begin_at = begin_at;
        this.description = description;
        this.end_at = end_at;
        this.full_name = full_name;
        this.id = id;
        this.league = league;
        this.league_id = league_id;
        this.modified_at = modified_at;
        this.name = name;
        this.season = season;
        this.slug = slug;
        this.tier = tier;
        this.tournaments = tournaments;
        this.videogame = videogame;
        this.videogame_title = videogame_title;
        this.winner_id = winner_id;
        this.winner_type = winner_type;
        this.year = year;
    }

    /**
     * Simple accessor for series start time.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series start time.
     */
    public String getBegin_at() {
        return begin_at;
    }

    /**
     * Simple accessor for series description.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Simple accessor for series end time.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series end time.
     */
    public String getEnd_at() {
        return end_at;
    }

    /**
     * Simple accessor for series full name.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series full name.
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * Simple accessor for series id.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series id.
     */
    public int getId() {
        return id;
    }

    /**
     * Simple accessor for series league.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series league.
     */
    public Object getLeague() {
        return league;
    }

    /**
     * Simple accessor for series league id.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series league id.
     */
    public int getLeague_id() {
        return league_id;
    }

    /**
     * Simple accessor for series modified time.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series modified time.
     */
    public String getModified_at() {
        return modified_at;
    }

    /**
     * Simple accessor for series name.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series name.
     */
    public String getName() {
        return name;
    }

    /**
     * Simple accessor for series season.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series season.
     */
    public String getSeason() {
        return season;
    }

    /**
     * Simple accessor for series slug.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series slug.
     */
    public String getSlug() {
        return slug;
    }

    /**
     * Simple accessor for series tier.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series tier.
     */
    public String getTier() {
        return tier;
    }

    /**
     * Simple accessor for series tournaments.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series tournaments.
     */
    public List<Object> getTournaments() {
        return tournaments;
    }

    /**
     * Simple accessor for series video game.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series video game.
     */
    public Object getVideogame() {
        return videogame;
    }

    /**
     * Simple accessor for series video game title.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series videogame title.
     */
    public Object getVideogame_title() {
        return videogame_title;
    }

    /**
     * Simple accessor for series winner id.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series winner id.
     */
    public int getWinner_id() {
        return winner_id;
    }

    /**
     * Simple accessor for series winner type.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series winner type.
     */
    public String getWinner_type() {
        return winner_type;
    }

    /**
     * Simple accessor for series year.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Simple accessor for series representation.<br><br>
     * <b>Preconditions:</b><br>
     * None<br>
     * <b>Postconditions:</b><br>
     * None<br>
     *
     * @return The series representation.
     */
    @Override
    public String toString() {
        return full_name + " Series";
    }

}
