import { Component, OnInit } from '@angular/core';
import Book from 'src/app/Entity/Book';
import { BookService } from 'src/app/Services/book.service';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  book: Book = new Book();

  save(){
    const observable = this.bookService.createbook(this.book);
    observable.subscribe((response:any)=>{
      console.log(response);
      
    }, function(error){
      console.log(error);
      alert("Something went wrong please try again")
      
    })
    
  }


  constructor(private bookService: BookService) { }

  ngOnInit(): void {
  }

}
