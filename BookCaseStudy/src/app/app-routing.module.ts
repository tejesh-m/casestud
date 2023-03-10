import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorComponent } from './Components/author/author.component';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { ReaderComponent } from './Components/reader/reader.component';
import { RegbooksComponent } from './Components/regbooks/regbooks.component';
import { SignupComponent } from './Components/signup/signup.component';

const routes: Routes = [{path:"regbooks", component:RegbooksComponent}, {path:"creatbook", component:AuthorComponent},
{path:"searchbooks", component:ReaderComponent}, {path: "", component:HomeComponent}, {path:"signup", component:SignupComponent},
{path:"login", component:LoginComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
