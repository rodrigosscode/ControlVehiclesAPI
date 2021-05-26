package br.com.zup.controlvehicles.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "tbl_moto")
@PrimaryKeyJoinColumn(name="veiculoId")
public class Moto extends Veiculo {

}
