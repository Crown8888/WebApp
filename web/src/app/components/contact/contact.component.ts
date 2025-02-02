import { Component } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

interface contact {
  name: string;
  email: string;
  message: string;
}


@Component({
  selector: 'app-contact',
  imports: [CommonModule, FormsModule],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.css'
})
export class ContactComponent {

  contact: contact = {
    name: '',
    email: '',
    message: ''
  };

  sendMessage() {
    console.log('Wiadomość została wysłana.');
    this.contact = {
      name: '',
      email: '',
      message: ''
    }
  }

}
