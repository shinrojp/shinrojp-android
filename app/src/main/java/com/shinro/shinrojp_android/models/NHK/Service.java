
package com.shinro.shinrojp_android.models.NHK;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo_s")
    @Expose
    private LogoS logoS;
    @SerializedName("logo_m")
    @Expose
    private LogoM logoM;
    @SerializedName("logo_l")
    @Expose
    private LogoL logoL;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LogoS getLogoS() {
        return logoS;
    }

    public void setLogoS(LogoS logoS) {
        this.logoS = logoS;
    }

    public LogoM getLogoM() {
        return logoM;
    }

    public void setLogoM(LogoM logoM) {
        this.logoM = logoM;
    }

    public LogoL getLogoL() {
        return logoL;
    }

    public void setLogoL(LogoL logoL) {
        this.logoL = logoL;
    }

}
