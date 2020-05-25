package fi.nls.oskari.domain.map.userlayer;


import fi.nls.oskari.domain.map.UserDataLayer;
import org.json.JSONArray;

public class UserLayer extends UserDataLayer {
    public static final String TYPE = "userlayer";
    private long id;
    private String layer_name;
    private String layer_desc;
    private String layer_source;
    private JSONArray fields;
    private int features_count;
    private int features_skipped; //if geojson feature doesn't have geometry object or it's null, feature is skipped
    private String wkt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLayer_name() {
        return layer_name;
    }

    public void setLayer_name(String layer_name) {
        this.layer_name = layer_name;
    }

    public String getLayer_desc() {
        return layer_desc;
    }

    public void setLayer_desc(String layer_desc) {
        this.layer_desc = layer_desc;
    }

    public String getLayer_source() {
        return layer_source;
    }

    public void setLayer_source(String layer_source) {
        this.layer_source = layer_source;
    }

    public JSONArray getFields() {
        return fields;
    }

    public void setFields(JSONArray fields) {
        if (fields == null) {
            this.fields = new JSONArray();
            return;
        }
        this.fields = fields;
    }

    public int getFeatures_count (){
        return features_count;
    }

    public void setFeatures_count (int count){
        this.features_count = count;
    }
    public int getFeatures_skipped (){
        return features_skipped;
    }

    public void setFeatures_skipped (int noGeometry){
        this.features_skipped = noGeometry;
    }

    public String getWkt() {
        return wkt;
    }

    public void setWkt(String wkt) {
        this.wkt = wkt;
    }

}
