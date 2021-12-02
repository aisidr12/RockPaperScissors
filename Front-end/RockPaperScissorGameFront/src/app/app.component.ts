import { Component, OnInit } from '@angular/core';
import { GameResult } from './model/GameResult';
import { PlayService } from './services/play.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  public totalPlayed:number=0;
  counterDraw:number=0;
  counterPlayerSecondWin:number=0;
  counterPLayerFirstWin:number=0;

  constructor(private playService:PlayService){
    this.mostrarListaResultados();
  }
  ngOnInit(): void { 

  }
  title = 'RockPaperScissorGameFront';
  optionEnviada: number = 0;
  selectedValue:string='';
  options : string[] = ['RandomSelection', 'RockSeleccion'];
  resultados : GameResult[] = [];

  public resetGame(){
    this.playService.reset().subscribe(val =>{
      console.log("Reset the game  "+ val );
      this.resultados=[];
    });
  }

  public getCounterFirstWinner(){
    this.playService.getNumeroVictoriasPlayerOne().subscribe(value =>{
      this.counterPLayerFirstWin = value;
    })
  }
  public getCounterSecondWinner(){
    this.playService.getNumeroVictoriasPlayerTwo().subscribe(value =>{
      this.counterPlayerSecondWin = value;
    })
  }
  public getcounterDraw(){
    this.playService.getTotalDraw().subscribe(counter =>{
      this.counterDraw = counter;
    })
  }

  public getTotalPlayed(){
    this.playService.getNumeroJugadas().subscribe(valor =>{
      console.log("valor obtenido" + valor);
      this.totalPlayed = valor;
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
