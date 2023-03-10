import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Book from '../Entity/Book';

const BASE_URL = 'http://localhost:8086/api/v1/digitalbooks/';
const BASE_URL2 = 'http://localhost:8088/api/v1/digitalbooks/';
 
@Injectable({
  providedIn: 'root'
})
export class BookService {

  private BASE_URL1= 'http://localhost:8086/api/v1/digitalbooks/search';
  
  createbook(book:{
    title:String,
    category:String,
    price:number,
    author:String,
    publisher:String,
    publisheddate:number,
    chapters:String,
    active:boolean
  }){
       return this.http.post(BASE_URL+"author"+"/"+"books", book);
  }

  getbooks(){
    return this.http.get(BASE_URL+"author"+"/"+"allbooks");
}

deletebook(book:any){
  return this.http.delete(BASE_URL+"remove"+"/"+book.bookid);
}

getBookBySearch(title:String, author:String, publisher:String, publisheddate:number):Observable<Book[]>{
  console.log(`${this.BASE_URL1}/?title=${title}&author=${author}&publisher=${publisher}&publisheddate=${publisheddate}`);
  return this.http.get<Book[]>(`${this.BASE_URL1}/?title=${title}&author=${author}&publisher=${publisher}&publisheddate=${publisheddate}`)
}

signupReader(signup:{
  name:String,
  remailid:String,
  rpassword:String
}){
  return this.http.post(BASE_URL2+"reader"+"/"+"signup", signup);
}

  constructor(public http: HttpClient) { }
}
