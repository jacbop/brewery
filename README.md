# brewery

```
git clone git@github.com:martylamb/nailgun.git
cd nailgun
make && sudo make install
cd ..
git clone git@github.com:jacbop/brewery.git
cd brewery
mvn install
./run
ng temp
```

## temp
(observedTemp: Double) => actualTemp: Double

curve - empirical difference from readout vs thermapen
delta - PID offset setting
delta zero - temp at which delta is "zeroed"

## vol

chiller, dead space, thermal expansion, ground water temp

## strike water vol and temp
grain temp, absorption

## efficiency
pounds of grain and quanitity of hops

## time to heat, to cool

## infusion calcs

split Observables from Constants and Reference
factor curves with input and output transformations
centralize calc logic in one place sep from commands
