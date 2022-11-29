import { Component, OnInit } from '@angular/core';
import{HttpClient, HttpClientModule, HttpHeaders}from '@angular/common/http'

@Component({
  selector: 'app-calc',
  templateUrl: './calc.component.html',
  styleUrls: ['./calc.component.css']
})
export class CalcComponent implements OnInit {

  constructor(private http : HttpClient) { }

  ngOnInit(): void {
  }

  public previous = ""; // to display previous calculation
  public current = "0"; // to display current input
  public lst = "0"; // a variable to store the last input
  public op = "";   // a variable to store the lat operation inserted
  public res : any = 0; // a variable to store the result

  send(x : string){
    const headers = new HttpHeaders({'Content-Type' : "application/text"})
    this.http.post('http://localhost:8080/calculate/expression', x,
    {headers : headers, responseType : 'text'})
    .subscribe((response) => {
      this.res = response
      this.current = this.res.toString();
      if(this.lst != "=" && this.lst != "sqr=" && this.lst != "sqrt=" && this.lst != "invert=" && this.lst != "%") this.previous = this.current + " " + this.lst;
    })
  }

  calcPercentage(){
      if(this.current == "E") return;
      this.lst = "%";
      this.previous = "";
      this.send(this.current + "%%");
  }

  clearAll(){
    this.previous = "";
    this.current = "0";
    this.op = "";
    this.lst = "0";
    this.res = 0;
  }

  delete(){
      if(this.current == "E") this.clearAll();
      if(this.lst == this.op || this.lst == "=") return;
      if(this.current.length == 1 || (this.current.length == 2 && this.current[0] == "-")){
        this.current = "0";
      }
      else if(this.current.length > 1){
        this.current = this.current.substring(0 , this.current.length - 1);
      }
  }

  getInvert(){
      if(this.current == "E") return;
      if(this.previous == "" || this.lst == "="){
        this.previous = "1/" + this.current;
      }
      this.lst = "="; 
      this.send(this.current + "nn");
  }

  calcSquare(){
      if(this.current == "E") return;
      if(this.previous == "" || this.lst == "="){
        this.previous = "sqr(" + this.current + ")";
      }
      this.lst = "=";
      this.send(this.current + "ss");
  }

  calcSquareRoot(){
      if(this.current == "E") return;
      if(this.previous == "" || this.lst == "="){
        this.previous = "sqrt(" + this.current + ")";
      }
      this.lst = "=";
      this.send(this.current + "rr");
  }

  changeSign(){
      if(this.current == "E") return;
      let x : number = parseFloat(this.current);
      x = x * -1;
      this.current = x.toString();
  }

  getResult(){
      if(this.previous.charAt(this.previous.length - 1) == "=" || this.current == "E") return;
      this.previous = this.previous + " " + this.current + " =";
      this.send(this.previous);
      this.lst = "=";
  }

  insertNumber(num : string){
      // inserting a number after calculating a previous operation means that we will start over
      if(this.lst == "=" || this.current == "E"){
        this.previous = "";
        this.current = num;
      }
      else if(this.current == "0" && num == "."){
        this.current = "0.";
      }
      else if(this.current == "0" || this.lst == this.op){
        this.current = num;
      }
      else{
        this.current = this.current + num;
      }
      this.lst = num;
  }

  insertOperation(operation : string){
      if(this.current == "E") return;
      if(this.op == this.lst){
        this.lst = operation;
      }
      else if(this.lst == "="){
        this.previous = this.current + " " + operation;
      }
      else{
        this.previous = this.previous + " " + this.current + " " + operation;
      }
      this.send(this.previous);
      this.op = operation;
      this.lst = operation;
  }

}
