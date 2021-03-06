System.register(['./../BaseSystemStatus.Component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __extends = (this && this.__extends) || function (d, b) {
        for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
    var BaseSystemStatus_Component_1;
    var BatimentSystemStatusComponent;
    return {
        setters:[
            function (BaseSystemStatus_Component_1_1) {
                BaseSystemStatus_Component_1 = BaseSystemStatus_Component_1_1;
            }],
        execute: function() {
            BatimentSystemStatusComponent = (function (_super) {
                __extends(BatimentSystemStatusComponent, _super);
                function BatimentSystemStatusComponent() {
                    _super.call(this, "#BatimentSystemStatus", "#BatimentEntity");
                    console.log('...>> BatimentSystemStatusComponent <<...');
                }
                return BatimentSystemStatusComponent;
            }(BaseSystemStatus_Component_1.BaseSystemStatusComponent));
            exports_1("BatimentSystemStatusComponent", BatimentSystemStatusComponent);
        }
    }
});
//# sourceMappingURL=BatimentSystemStatus.Component.js.map