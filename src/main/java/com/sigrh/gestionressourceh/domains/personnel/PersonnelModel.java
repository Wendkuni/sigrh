package com.sigrh.gestionressourceh.domains.personnel;

import com.sigrh.gestionressourceh.common.constant.TypeEducation;
import lombok.*;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PersonnelModel implements Serializable {
    private long idAgent;
    private String matricule;
    private String nomPrenom;
    private String nomPrenomArab;
    private String nni;
    private LocalDate dteRecrutement;
    private LocalDate dteTitularisation;
    private LocalDate dteSortie;
    private String statusEmp;
    private String tlphone;
    private String adressEmp;
    private LocalDate debutCntrat;
    private LocalDate finCntrat;
    private LocalDate dateNaiss;
    private String lieuNaiss;
    private String actifOrNot;
    private String bank;
    private String codeBank;
    private String numroCpte;
    private String cleRib;
    private String detacher;
    private String ministerOrigine;
    @Enumerated(EnumType.STRING)
    private TypeEducation Typeeducation;
    private byte[] imagPers;


    /*public String toString() {
        return nomPrenom +" Mle:"+matricule+" Nni:"+nni;
    }*/
}
