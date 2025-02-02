import { NgModule } from '@angular/core';

import { FeatherModule } from 'angular-feather';
import {User, Lock, Plus} from 'angular-feather/icons';

const icons = {
  User,
  Lock,
  Plus
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
