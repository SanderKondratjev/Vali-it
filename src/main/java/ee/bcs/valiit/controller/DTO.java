package ee.bcs.valiit.controller;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

public class DTO {
    private String töötajad;
    private String aadress;

    public String getTöötajad() {
        return töötajad;
    }

    public void setTöötajad(String töötajad) {
        this.töötajad = töötajad;
    }

    public String getAadress() {
        return aadress;
    }

    public void setAadress(String aadress) {
        this.aadress = aadress;
    }
}