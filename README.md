# mdsp-his

Simulation of a hostipal information system for medical data security system.

### apis

1. GET /users/{id}
2. GET /users/id?idcard=xxx
3. GET /recipes/{id}
4. GET /recipes?userId=xxx
5. GET /assays/{id}
6. GET /assays?userId=xxx

### tips

1. *.hbm.xml的id字段要加上<generator class="native"/>才会自动生成，IDEA的Persistence插件生成的XML文件不会对应数据库生成这一属性；
2. IDEA的Persistence插件生成的*.hbm.xml中字段始终为NOT NULL；
3. 遇到部分字段Lazy加载的问题可以在获取对象方法的注解中加入fetch = FetchType.EAGER；
4. 上述问题还有一种解决方法，在*.hbm.xml中对应标签中加入lazy="false"关闭Lazy加载；
5. Hibernate的one-to-many映射时，如果使用list需要设置index方法，可以在*.hbm.xml的list标签中加入index标签。