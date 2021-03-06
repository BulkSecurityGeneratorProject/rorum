import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {RorumSharedModule} from '../shared';
import {
    adminState, AuditsComponent, AuditsService, JhiConfigurationComponent, JhiConfigurationService,
    JhiDocsComponent, JhiHealthCheckComponent, JhiHealthModalComponent, JhiHealthService, JhiMetricsMonitoringComponent,
    JhiMetricsMonitoringModalComponent, JhiMetricsService, LogsComponent, LogsService, UserDeleteDialogComponent,
    UserDialogComponent, UserMgmtComponent, UserMgmtDeleteDialogComponent, UserMgmtDetailComponent,
    UserMgmtDialogComponent, UserModalService, UserResolve, UserResolvePagingParams
} from './';
import {RolePipe} from "./user-management/pipes/role.pipe";

/* jhipster-needle-add-admin-module-import - JHipster will add admin modules imports here */

@NgModule({
    imports: [
        RorumSharedModule,
        RouterModule.forRoot(adminState, { useHash: true }),
        /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
    ],
    declarations: [
        AuditsComponent,
        UserMgmtComponent,
        UserDialogComponent,
        UserDeleteDialogComponent,
        UserMgmtDetailComponent,
        UserMgmtDialogComponent,
        UserMgmtDeleteDialogComponent,
        LogsComponent,
        JhiConfigurationComponent,
        JhiHealthCheckComponent,
        JhiHealthModalComponent,
        JhiDocsComponent,
        JhiMetricsMonitoringComponent,
        JhiMetricsMonitoringModalComponent,
        RolePipe,

    ],
    entryComponents: [
        UserMgmtDialogComponent,
        UserMgmtDeleteDialogComponent,
        JhiHealthModalComponent,
        JhiMetricsMonitoringModalComponent,
    ],
    providers: [
        AuditsService,
        JhiConfigurationService,
        JhiHealthService,
        JhiMetricsService,
        LogsService,
        UserResolvePagingParams,
        UserResolve,
        UserModalService,
        RolePipe,

    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RorumAdminModule {}
