# EjLayoutEstaticoConFragmentDinamicoYLayoutAlt
Ejercicio de manejo de Fragments dinámicos con layouts alternativos. En este repositorio hay varias ramas con diferentes soluciones: una con error y dos buenas.

En la rama "master" tenemos la primera solución planteada que es la que tiene un error en este código:

@Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_activity_detalle);

        mFragmentManager = getSupportFragmentManager();

        //obtengo la url a mostrar
        url = getIntent().getStringExtra(EXTRA_URL);

        // Comprobamos que previamente no hayamos entrado en esta actividad (por ejemplo, al rotar el dispositivo).
        // Si es así se añade el fragmento al contenedor
        if (savedInstanceState == null) {
            //creo el fragment
            wvFragment = new WebViewFragment();
            //lo añado al layout

            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.contenedorWebFragment, wvFragment);
            fragmentTransaction.commit();
            // Force Android to execute the committed FragmentTransaction
            mFragmentManager.executePendingTransactions();
        } else {
            //ya existe el fragment,pues la activity ya fue creada antes
            //Por tanto, lo recojo usando el mFragmentManager.
            wvFragment = (WebViewFragment) mFragmentManager.getFragments().get(0);
        }

        if (!wvFragment.getActualUrl().equals(url)) {
            wvFragment.mostrarUrl(url);
        }

    }
    
    
    En concreto el error está en las líneas 35 y 36.
    
    En las otras dos ramas hay sendas soluciones a ese error.
