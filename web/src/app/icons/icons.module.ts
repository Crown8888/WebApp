import { NgModule } from '@angular/core';

import { FeatherModule } from 'angular-feather';
import {User, Lock} from 'angular-feather/icons';

const icons = {
  User,
  Lock
};

@NgModule({
  imports: [
    FeatherModule.pick(icons)
  ],
  exports: [
    FeatherModule
  ]
})
export class IconsModule { }
