import {ApplicationConfig, importProvidersFrom, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import {provideHttpClient, withInterceptorsFromDi} from '@angular/common/http';
import {JwtModule} from '@auth0/angular-jwt';
import {tokenGetter} from './services/auth.service';

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(
      withInterceptorsFromDi()
    ),
    importProvidersFrom(
      JwtModule.forRoot({
        config: {
          tokenGetter: tokenGetter,
          allowedDomains: [],
          disallowedRoutes: [],
        },
      }),
    ),
  ]
};
export const environment = {
  apiUrl: 'http://localhost:8080/api'
};
