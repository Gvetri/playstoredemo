package giuseppevetri.grabilityapp.models.apps.apps_attributes;

/**
 * Created by giuseppe on 07/01/17.
 */

public class Category {
    private String label;
    private CategoryAttributes categoryAttributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public CategoryAttributes getCategoryAttributes() {
        return categoryAttributes;
    }

    public void setCategoryAttributes(CategoryAttributes categoryAttributes) {
        this.categoryAttributes = categoryAttributes;
    }
}
