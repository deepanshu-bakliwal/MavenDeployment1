import { Injectable } from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { User } from '../user';


@Injectable()
export class RegistrationService{
    
    users: User[];
    url: String
    
    constructor(private http:HttpClient) {

    }
    retriveFromServer(url, users){

      return this.http.post(url, users);
      
    }
}