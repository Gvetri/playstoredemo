package giuseppevetri.grabilityapp.models.apps;

import giuseppevetri.grabilityapp.models.apps.apps_attributes.Artist;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Category;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Image;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Link;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Name;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Price;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.ReleaseDate;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Rights;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Summary;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Title;

/**
 * Created by giuseppe on 07/01/17.
 */

public class App {
    private Name name;
    private Image image;
    private Summary summary;
    private Price price;
    private Rights rights;
    private Title title;
    private Link link;
    private Artist artist;
    private Category category;
    private ReleaseDate releaseDate;

    public App(Name name, Image image, Summary summary, Price price, Rights rights, Title title, Link link, Artist artist, Category category, ReleaseDate releaseDate) {
        this.name = name;
        this.image = image;
        this.summary = summary;
        this.price = price;
        this.rights = rights;
        this.title = title;
        this.link = link;
        this.artist = artist;
        this.category = category;
        this.releaseDate = releaseDate;
    }

    public App(Name name, Image image, Summary summary, Price price) {
        this.name = name;
        this.image = image;
        this.summary = summary;
        this.price = price;
    }

    public App(Name name, Summary summary, Price price) {
        this.name = name;
        this.summary = summary;
        this.price = price;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(ReleaseDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
