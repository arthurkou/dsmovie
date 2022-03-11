import FormCard from 'components/FormCard';
import { useParams } from 'react-router-dom';



function Form() {

    //busca parametro da requisicao
    const params = useParams();

    return (
        <FormCard movieId={`${params.movieId}`} />
    );
}

export default Form;