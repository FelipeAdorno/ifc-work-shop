package br.com.ifc.enums;

/**
 * The enum Flag enum.
 * @author Felipe Adorno (felipeadsc@gmail.com)
 */
public enum FlagEnum {

    VISA(1),
    CIELO(2);

    private Integer flag;

    FlagEnum(final Integer flag) {
        this.flag = flag;
    }

    public Integer getFlag() {
        return flag;
    }
}
