# mdsp-his

Simulation of a hostipal information system for medical data security system.

### tips
1. *.hbm.xml的id字段要加上<generator class="native"/>才会自动生成，IDEA的Persistence插件生成的XML文件不会对应数据库生成这一属性;
2. IDEA的Persistence插件生成的*.hbm.xml中字段始终为NOT NULL。