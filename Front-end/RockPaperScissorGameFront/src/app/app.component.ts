import { Component, OnInit } from '@angular/core';
import { GameResult } from './model/GameResult';
import { PlayService } from './services/play.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private playService:PlayService){

  }
  ngOnInit(): void { 
    this.mostrarListaResultados();
  }
  title = 'RockPaperScissorGameFront';
  optionEnviada: number = 0;
  selectedValue:string='';
  options : string[] = ['RandomSelection', 'RockSeleccion'];
  resultados : GameResult[] = [];


  radioChangeHandler(event:any,i:number){
    this.selectedValue = event.target.value;
    console.log("elegiste : "+this.selectedValue);
    this.optionEnviada = i;
    console.log("optionEnviada : "+this.optionEnviada);
  }

  public mostrarNumber(){
    this.playService.getNumeroJugadas().subscribe(valor =>{
      console.log("valor obtenido" + valor);
    });
  }

  public mostrarListaResultados(){
    this.playService.getResultados().subscribe(valor =>{
  
      console.log("Los resultados son" + valor);
      this.resultados = valor;
    })
  }

  public empezarJuego(valor:string){
    this.playService.jugar(valor).subscribe(valor =>{
   
      console.log("El valor para jugar es: "+valor);
    })
  }

}
