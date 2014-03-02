# head

```
    @Override
    MethodHandle bindArgument(int pos, char basicType, Object value) {
        MethodType type = type().dropParameterTypes(pos, pos+1);
        LambdaForm form = internalForm().bind(1+pos, speciesData());
        return cloneExtend(type, form, basicType, value);
    }
```

 - 1
 - 2
 - 3

 *bb* dfkfjd

