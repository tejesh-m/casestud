import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Book from 'src/app/Entity/Book';
import { BookService } from 'src/app/Services/book.service';

@Component({
  selector: 'app-reader',
  templateUrl: './reader.component.html',
  styleUrls: ['./reader.component.css']
})
export class ReaderComponent implements OnInit {

  title:String;
  author:String;
  publisher:String;
  publisheddate:number

  book:Book = new Book();
  books:Book[]=[];

  constructor(private bookservice: BookService) { }

  searchBook(){
    this.bookservice.getBookBySearch(this.book.title, this.book.author, this.book.publisher, this.book.publisheddate).subscribe(
      data => {
        this.books=data;
        console.log(data);
        
      }, 
      error => console.log(error)
      
    )
  }

  ngOnInit(): void {
  }

}
