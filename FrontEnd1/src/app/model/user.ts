import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class User {
  username: string;
  password: string;
  roles: any;
  constructor(){}
}
