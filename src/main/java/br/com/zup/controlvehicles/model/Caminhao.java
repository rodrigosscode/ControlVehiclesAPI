package br.com.zup.controlvehicles.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "tbl_caminhao")
@PrimaryKeyJoinColumn(name="veiculoId")
public class Caminhao extends Veiculo {

}
