import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GameResult } from '../model/GameResult';

@Injectable({
  providedIn: 'root'
})
export class PlayService {

  private baseEndpoint = 'http://localhost:8080/RockPaperScissors/'

  constructor(private http: HttpClient) {

  }

  public jugar(valor: string): Observable<GameResult> {
    return this.http.post<GameResult>(this.baseEndpoint + "jugar/" + valor, null);
  }

  public reset(): Observable<any> {
    return this.http.post(this.baseEndpoint + "/reset", null);
  }

  public getNumeroJugadas(): Observable<any> {
    return this.http.get<any>(this.baseEndpoint + "jugadas");
  }

  public getResultados(): Observable<GameResult[]> {
    return this.http.get<GameResult[]>(this.baseEndpoint + "resultados");
  }

  public getNumeroVictoriasPlayerOne(): Observable<number> {
    return this.http.get<any>(this.baseEndpoint + "totalFirstPlayer");
  }

  public getNumeroVictoriasPlayerTwo() :Observable<Number>{
    return this.http.get<any>(this.baseEndpoint + "totalSecondPlayer");
  }

 public getTotalDraw() :Observable<Number>{
  return this.http.get<any>(this.baseEndpoint + "totalDraw");
  }
}
