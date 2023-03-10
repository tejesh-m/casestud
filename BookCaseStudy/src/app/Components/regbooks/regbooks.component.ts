import { Component, OnInit } from '@angular/core';
import Book from 'src/app/Entity/Book';
import { BookService } from 'src/app/Services/book.service';

@Component({
  selector: 'app-regbooks',
  templateUrl: './regbooks.component.html',
  styleUrls: ['./regbooks.component.css']
})
export class RegbooksComponent implements OnInit {

  deleteRow(book: any, index: number){
    const observables = this.bookservice.deletebook(book);
    observables.subscribe((response:any)=>{
      console.log(response);
      this.books.splice(index, 1)
      
    })

  }

  books: Book[] = [];

  constructor(private bookservice: BookService) { }

  ngOnInit(): void {
    const promise = this.bookservice.getbooks();
    promise.subscribe((response)=>{
      console.log(response);
      this.books = response as Book[];

    })
  }

}
