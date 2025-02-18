import {ApplicationConfig, importProvidersFrom, LOCALE_ID, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import {HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi} from '@angular/common/http';
import {JwtModule} from '@auth0/angular-jwt';
import {tokenGetter} from './services/auth.service';
import {JwtInterceptor} from './jwt.interceptor';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import localePl from '@angular/common/locales/pl';
import {registerLocaleData} from '@angular/common';

registerLocaleData(localePl);

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(withInterceptorsFromDi()),
    {
      provide:HTTP_INTERCEPTORS,
      useClass:JwtInterceptor,
      multi:true
    },
    importProvidersFrom(
      JwtModule.forRoot({
        config: {
          tokenGetter: tokenGetter,
          allowedDomains: [],
          disallowedRoutes: [],
        },
      }),
    ), provideAnimationsAsync(),
    {provide: LOCALE_ID, useValue: 'pl'}
  ]
};
export const environment = {
  apiUrl: 'http://localhost:8080/api'
};
