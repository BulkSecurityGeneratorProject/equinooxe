System.register([], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var Index, EtageDeleteTask, app;
    return {
        setters:[],
        execute: function() {
            Index = (function () {
                function Index() {
                    console.log('Espaces Index');
                    Vue.component('my-component', {
                        template: '<div>A custom component!</div>'
                    });
                    var cmp = {
                        el: "#e1",
                        template: "<ul class=\"no-style\">\n               <li v-for=\"etage in batiment.etages\" title=\"etage.description\">\n                  {{ etage.nom }} \n                  <form  method=\"post\" name=\"removeFormModel\">\n                     <input type=\"hidden\" name=\"id\" value=\"etage.id\"/>\n                     <input type=\"hidden\" name=\"redirectTo\" value=\"\"/>\n                     <button v-on:click=\"deleteEtage($event,etage.id)\" class=\"btn-gray\">Supprimer</button>\n                  </form>\n               </li>\n            </ul> \n            ",
                        methods: {
                            deleteEtage: EtageDeleteTask,
                        },
                        data: function () {
                            var _data = this;
                            return {
                                batiment: JSON.parse($("#Model").text())
                            };
                        }
                    };
                    Index.mainView = new Vue(cmp);
                }
                return Index;
            }());
            exports_1("Index", Index);
            EtageDeleteTask = (function () {
                function EtageDeleteTask(evt, etageId, data) {
                    if (data === void 0) { data = null; }
                    data = Index.mainView.batiment;
                    console.log(data);
                    console.log("main", Index.mainView);
                    evt.preventDefault();
                    data.etages.forEach(function (etage) {
                        if (etage.id == etageId) {
                            console.log("Start deleting", etage.id);
                            axios.delete("/api/etage/delete/" + etage.id).then(function (res) {
                                alert(res.data);
                                data.etages = data.etages.filter(function (obj) {
                                    return etage.id === etageId;
                                });
                            });
                        }
                    });
                }
                return EtageDeleteTask;
            }());
            exports_1("EtageDeleteTask", EtageDeleteTask);
            app = new Index();
        }
    }
});
//# sourceMappingURL=index.js.map